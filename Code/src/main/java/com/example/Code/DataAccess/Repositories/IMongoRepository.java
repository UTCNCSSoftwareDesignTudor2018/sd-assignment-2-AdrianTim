package com.example.Code.DataAccess.Repositories;

import com.example.Code.BusinessLogic.BusinessModels.Report;
import com.mongodb.DBObject;


public interface IMongoRepository {

    void saveReport(Report report);
    DBObject findDocuments();
    void setup();
    void generateExampleReport();

}
