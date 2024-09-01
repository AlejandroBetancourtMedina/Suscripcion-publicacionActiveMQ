package org.example;

import org.example.jms.JmsPublisher;
import org.example.models.Company;
import org.example.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class SpringActiveMqTopicProducerApplication implements CommandLineRunner {

        @Autowired
        JmsPublisher publisher;

        public static void main(String[] args){
            SpringApplication.run(SpringActiveMqTopicProducerApplication.class, args);}

        @Override
        public void run(String...args) throws  Exception {
        Product iphone7 = new Product("Iphone 7");
        Product ipadPro = new Product("IpadPro");
        List<Product> appleProducts = new ArrayList<>(Arrays.asList(iphone7, ipadPro));
        Company apple = new Company ("Apple", appleProducts);
        iphone7.setCompany(apple);
        ipadPro.setCompany(apple);

        publisher.send(apple);

        Product galaxyS8 = new Product("Galaxy S8");
        Product gearS3 = new Product("Gear S3");
        List<Product> samsungProducts = new ArrayList<>(Arrays.asList(galaxyS8, gearS3));
        Company samsung = new Company("Samsung", samsungProducts);
        galaxyS8.setCompany(samsung);
        gearS3.setCompany(samsung);

        publisher.send(samsung);



            }

        }

