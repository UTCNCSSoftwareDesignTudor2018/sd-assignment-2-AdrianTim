package com.example.Code.DataAccess.Repositories.Implementations;

import com.example.Code.BusinessLogic.BusinessModels.Report;
import com.example.Code.DataAccess.Repositories.IMongoRepository;
import com.mongodb.*;

import org.springframework.stereotype.Service;

import java.net.UnknownHostException;


@Service
public class MongoRepository implements IMongoRepository {


    @Override
    public void saveReport(Report report) {

        try {

            MongoClient client = new MongoClient("localhost", 27017);
            DB db = client.getDB("Assig2");
            DBCollection collection = db.getCollection("Reports");

            BasicDBObject document = new BasicDBObject();
            document.put("Student name", report.getStudentName());
            document.put("Average", report.getGradeAverage());

            collection.insert(document);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public DBObject findDocuments(){

        try {

            MongoClient client = new MongoClient("localhost", 27017);
            DB db = client.getDB("Assig2");
            DBCollection collection = db.getCollection("Reports");

            DBCursor cursor = collection.find(new BasicDBObject());

            return cursor.next();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public void setup() {



    }

    @Override
    public void generateExampleReport() {

        try {

            MongoClient client = new MongoClient("localhost", 27017);
            DB db = client.getDB("Assig2");
            DBCollection collection = db.getCollection("Reports");

            BasicDBObject document = new BasicDBObject();
            document.put("Student name", "Adrian");
            document.put("Average", 7.6);

            collection.insert(document);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }


}
