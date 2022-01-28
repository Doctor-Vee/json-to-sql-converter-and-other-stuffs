package com.tests.jsontosql;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JsonToSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonToSqlApplication.class, args);

        // CODE TO CONVERT REDEEM INSTRUCTIONS FROM JSON TO SQL QUERY
        System.out.println("Hello world");
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<RedeemInstruction>> typeReference = new TypeReference<>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/redeemInstructions.json");
        try{
            List<RedeemInstruction> redeemInstructionList = mapper.readValue(inputStream, typeReference);
            FileWriter fileWriter = new FileWriter("file.txt");
            for (RedeemInstruction redeemInstruction : redeemInstructionList) {
                fileWriter.write(String.format("(%d, '%s', '%s'),\n", redeemInstruction.getBrandId(), redeemInstruction.getConcise(), redeemInstruction.getVerbose()));
            }
            fileWriter.close();
            System.out.println(redeemInstructionList.size());
        } catch (Exception e){
            System.out.println("Error Happened biko \n" + e.getMessage());
        }


//        // CODE TO CREATE A JSON FILE WITH EMPTY VALUES FOR REDEEM INSTRUCTIONS
//        System.out.println("Hello world");
//        try{
//            FileWriter fileWriter = new FileWriter("redeemInstructions.json");
//            fileWriter.write("[\n");
//            for (int i = 141; i<=147; i++) {
//                fileWriter.write(String.format("{\n\"brandId\": \"%d\",\n\"concise\": \"\",\n\"verbose\": \"\"\n},\n", i));
//            }
//            fileWriter.write("]");
//            fileWriter.close();
//            System.out.println("Done writing");
//        } catch (Exception e){
//            System.out.println("Error Happened biko \n" + e.getMessage());
//
//        }

//        // CODE TO GENERATE SQL SCRIPT TO POPULATE DB WITH 1000 GiftCard records
//        System.out.println("Code to generate SQL Script to populate DB with 1000 Giftcard Transactions");
//        StringBuilder initialSQL = new StringBuilder("INSERT INTO `transaction` (`portal_user_id`, `user_id`, `product_sku`, `product_id`, `product_title`, `pre_order`, `quantity`, `application_id`, `external_tracking_id`, `external_tracking_code`, `deducted_amount_usd`, `discount_usd`, `request_currency_code`, `fee`, `fee_in_user_currency`, `brand_id`, `brand_name`, `country_code`, `provider_id`, `provider_name`, `user_discount_percentage`,  `provider_discount_percentage`, `provider_product_id`, `unit_price`, `total_price`, `provider_fx_rate`, `recipient_email`, `sender_name`, `user_currency_exchange_rate`, `provider_fee`, `discount_in_user_currency`, `amount_in_user_currency`, `deducted_amount`, `deducted_amount_currency_code`, `request_currency_exchange_rate`, `using_local_amount`, `profit_usd`, `cost_usd`, `margin_percentage`, `margin_percentage_without_fee`, `status`, `created_at`)\n" +
//                "VALUES ");
//        List<String> products = Arrays.asList("1-800-PetSupplies", "Amazon UK", "Amazon France", "App Store & iTunes Austria");
//        List<String> emails = Arrays.asList("snnabugwu@reloadly.com", "vchinewubeze@reloadly.com", "doctorvee@gmail.com", "doctor@gmail.com");
//        List<Double> prices = Arrays.asList(1.0, 2.0, 3.0, 4.0);
//        for (int i = 1; i <= 1000; i++){
//            int m = i%4;
//            int qty = m + 1;
//            String values = "(1129, 1, 1061, 1, '" + products.get(m) + "', 0, " + qty + ", 4, '7049050357097305375" + i +"', '056df8b1-124d-4f92-857e-ef262420" + i +
//                    "', 12.343, 0.08671232, 'GBP', 1.500000000, 595.050765000, 2, 'Amazon Ukraine', 'GB', 1, 'EZPIN', 0.7, 1, 152, " + prices.get(m) +
//                    ", " + qty * prices.get(m) + ", 0.731101000, '" + emails.get(m) + "', 'Doctor Vee', 396.700510000, 0, 34.328672368, 5478.513779903, " +
//                    "5444.3295, 'NGN', 0.731101000, 0, 1.174734153, 12.549295440, 8.5597, -2.37, 'SUCCESSFUL', NOW()), \n";
//
//            initialSQL.append(values);
//        }
//        try{
//            FileWriter fileWriter = new FileWriter("giftCardTransactions.txt");
//            fileWriter.write(String.valueOf(initialSQL));
//            fileWriter.close();
//        } catch (Exception e){
//            System.out.println("Error oooooooo \n" + e.getMessage());
//        }
//        System.out.println("Done");


    }

}
