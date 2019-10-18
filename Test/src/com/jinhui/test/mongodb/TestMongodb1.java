package com.jinhui.test.mongodb;


import java.io.File;

import javax.print.Doc;

import org.bson.BSONObject;
import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;


/**
 * 2017-7-10下午01:42:19
 * TestMongodb1.java
 * author:liuyonghua
 */
public class TestMongodb1 {
	

	public static void main(String[] args) {
		
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			
			MongoDatabase db = mongo.getDatabase("test");
			DB db1 = mongo.getDB("test");

			MongoCollection<Document> user = db.getCollection("Person");
			
			FindIterable<Document> iterable = user.find();
			iterable.forEach(new Block<Document>() {
				public void apply(final Document document){
					System.out.println(document);
				}
			});
			//存储图片
			/*File imageFile = new File("d:\\ftp\\14bmp.bmp");
	        GridFS gfsPhoto = new GridFS(db1, "photo"); //connection为集合名词
	        GridFSInputFile gfsFile = null;
	            gfsFile = gfsPhoto.createFile(imageFile);
	        gfsFile.setId(111);
	        gfsFile.setContentType("image/jpeg");
	        gfsFile.save();*/
	        
	        //读取图片
	        String newFileName = "14bmp.bmp";
	        GridFS gfsPhoto = new GridFS(db1, "photo");
	        GridFSDBFile imageForOutput = gfsPhoto.findOne(newFileName);
	        System.out.println(imageForOutput);  //返回数据以BSON格式体现
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
