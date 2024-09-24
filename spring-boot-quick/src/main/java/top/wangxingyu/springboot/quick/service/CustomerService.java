package top.wangxingyu.springboot.quick.service;

import org.springframework.stereotype.Service;
import top.wangxingyu.springboot.quick.enums.RequestType;

@Service
public class CustomerService {
    public String handleRequest(RequestType requestType){
        return switch (requestType){
            case QUERY -> handleQuery();
            case COMPLAINT -> handleComplaint();
            case SUGGESTION -> handleSuggestion();
        };
    }

    private String handleQuery(){
        return "查询请求";
    }

    private String handleComplaint(){
        return "投诉请求";
    }

    private String handleSuggestion(){
        return "建议请求";
    }
}
