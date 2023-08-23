package com.example.writeagain.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.writeagain.javabean.Subject;
import com.example.writeagain.javabean.SubjectFromNetwork;
import com.example.writeagain.mapper.ExcelToSQLMapper;
import com.example.writeagain.service.uploaderService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.writeagain.vo.Constant.BATCH_COUNT;

@Component
public class DataListener extends AnalysisEventListener<SubjectFromNetwork> {
    private uploaderService service = BeanUtils.getBean(uploaderService.class);
    private ExcelToSQLMapper mapper = BeanUtils.getBean(ExcelToSQLMapper.class);
    List<SubjectFromNetwork> list = new ArrayList<>();

    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(SubjectFromNetwork data, AnalysisContext context) {
        System.out.println("解析到一条数据:" + data);
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        //BATCH_COUNT每次读取条数,可以设为10-1000条
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        System.out.println("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        System.out.println("{}条数据，开始存储数据库！" + list.size());
        List<Subject> newList = new ArrayList<Subject>();
        int firstId = mapper.lastInsertId()+1;
        for (SubjectFromNetwork subjectFromNetwork : list) {
            Subject subject = new Subject();
            if (subjectFromNetwork.get课程分类所属() == null) {
                int id = mapper.findIdByTitle(subjectFromNetwork.get课程分类名());
                if (id < 1) {
                    Date date = new Date();
                    subject.setTitle(subjectFromNetwork.get课程分类名());
                    subject.setId(firstId);
                    subject.setGmtCreated(date);
                    subject.setGmtModified(date);
                    newList.add(subject);
                    firstId++;
                }
            } else {
                Subject subject1 = new Subject();
                int id = mapper.findIdByTitle(subjectFromNetwork.get课程分类所属());
                for (Subject parent:
                        newList) {
                    boolean b = parent.getTitle() == subjectFromNetwork.get课程分类所属();
                    if (b){
                        id=parent.getId();
                    }
                }
                if (id < 1 ) {
                    Date date = new Date();
                    subject1.setParentId(firstId);
                    subject.setTitle(subjectFromNetwork.get课程分类所属());
                    subject.setGmtCreated(date);
                    subject.setGmtModified(date);
                    newList.add(subject);
                    firstId++;
                    subject1.setParentId(firstId);
                    subject1.setTitle(subjectFromNetwork.get课程分类名());
                    subject1.setGmtCreated(date);
                    subject1.setGmtModified(date);
                    newList.add(subject1);
                    firstId++;
                }else {
                    Date date = new Date();
                    subject1.setParentId(id);
                    subject1.setTitle(subjectFromNetwork.get课程分类名());
                    subject1.setGmtCreated(date);
                    subject1.setGmtModified(date);
                    newList.add(subject1);
                    firstId++;
                }
                }
            }
        mapper.saves(newList);
        System.out.println("存储数据库成功！");
    }
}