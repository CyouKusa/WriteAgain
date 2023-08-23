package com.example.writeagain.service.Impl;

import com.alibaba.excel.EasyExcel;
import com.example.writeagain.javabean.Subject;
import com.example.writeagain.javabean.SubjectFromNetwork;
import com.example.writeagain.mapper.ExcelToSQLMapper;
import com.example.writeagain.service.uploaderService;
import com.example.writeagain.utils.DataListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class uploaderServiceImpl implements uploaderService {
    @Autowired
    private ExcelToSQLMapper mapper;
    @Override
    public String uploadAvatar(MultipartFile file) {
        //创建日期格式,创建日期并放入格式形成指定格式的日期字符串,月份表示要大写,mm是分钟
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//指定日期格式
        String format = dateFormat.format(new Date());//创建当前时间对象,并转为指定格式的String
        //新建个路径为图床+日期字符串 , 注意最后加\\才能转到下级目录
        File folder = new File("D:\\nginx\\pic\\" + format);//把路径完整化
        //如果没有这个路径就在这个路径创建文件夹
        if (!folder.exists()){
            folder.mkdir();//创建文件夹
        }
        //提取上传文件的文件名,提取后缀名,生成UUID的字符串,合成文件名
        String oldName = file.getOriginalFilename();//抽出上传文件的文件名
        String extension = file.getOriginalFilename().substring(oldName.lastIndexOf("."));//lastIndexOF找出.所在下标,substring只能从下标截断
        String newName = UUID.randomUUID().toString() + extension;//用UUID的静态方法生成UUID,但格式要再转为String类型,然后才能组合后缀名
        //创建文件夹路径+文件名的File对象,因为transferTo的参数必须是File.将上传文件复制到指定文件(路径)上
        try {
            file.transferTo(new File(folder,newName));//new File可以放路径+文件名,自动以\\组合,形成一个文件路径
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //返回文件路径,是网络路径不是本地路径 , 以及注意加/
        return "http://127.0.0.1/"+format+"/"+newName;
    }

    @Override
    public void uploadExcel(MultipartFile file) {
        File folder = new File("D:\\nginx\\pic\\Excel上传");//把路径完整化
        //提取上传文件的文件名,提取后缀名,生成UUID的字符串,合成文件名
        String oldName = file.getOriginalFilename();//抽出上传文件的文件名
        String extension = file.getOriginalFilename().substring(oldName.lastIndexOf("."));//lastIndexOF找出.所在下标,substring只能从下标截断
        String newName = UUID.randomUUID().toString() + extension;//用UUID的静态方法生成UUID,但格式要再转为String类型,然后才能组合后缀名
        //创建文件夹路径+文件名的File对象,因为transferTo的参数必须是File.将上传文件复制到指定文件(路径)上
        try {
            file.transferTo(new File(folder,newName));//new File可以放路径+文件名,自动以\\组合,形成一个文件路径
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        String fileName =folder+"\\"+newName;
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, SubjectFromNetwork.class, new DataListener()).sheet().doRead();
    }

    @Override
    public int addSubject(Subject subject) {
        int nums = mapper.save(subject);
        return nums;
    }

    @Override
    public int addSubjects(List<Subject> list) {
        int nums = mapper.saves(list);
        return nums;
    }

    @Override
    public String uploadAvatar(File dfile) {
        //创建日期格式,创建日期并放入格式形成指定格式的日期字符串,月份表示要大写,mm是分钟
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//指定日期格式
        String format = dateFormat.format(new Date());//创建当前时间对象,并转为指定格式的String
        //新建个路径为图床+日期字符串 , 注意最后加\\才能转到下级目录
        File folder = new File("D:\\nginx\\pic\\" + format);//把路径完整化
        //如果没有这个路径就在这个路径创建文件夹
        if (!folder.exists()){
            folder.mkdir();//创建文件夹
        }
        //提取上传文件的文件名,提取后缀名,生成UUID的字符串,合成文件名
        String oldName = dfile.getName();//抽出上传文件的文件名
        String extension = dfile.getName().substring(oldName.lastIndexOf("."));//lastIndexOF找出.所在下标,substring只能从下标截断
        String fileName = UUID.randomUUID().toString() + extension;//用UUID的静态方法生成UUID,但格式要再转为String类型,然后才能组合后缀名
        FileInputStream in = null;//字节输入流
        FileOutputStream out = null;
        try {
            in = new FileInputStream(dfile);
            out = new FileOutputStream(new File(folder,fileName));
            byte[] b= new byte[1024];
            int len = 0;
            while((len = in.read(b))!=-1){
                out.write(b,0,len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return "http://127.0.0.1/"+format+"/"+fileName;
        }
    }
}
