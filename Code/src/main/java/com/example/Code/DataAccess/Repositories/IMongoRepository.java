package com.example.Code.DataAccess.Repositories;

import com.example.Code.BusinessLogic.BusinessModels.Report;

public interface IMongoRepository {

    void saveReport(Report report);

}
