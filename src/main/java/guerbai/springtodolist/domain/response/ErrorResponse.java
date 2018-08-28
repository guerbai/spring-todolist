package guerbai.springtodolist.domain.response;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ErrorResponse extends ResponseEntity<JSONObject> {


    public ErrorResponse() {
        super(new JSONObject(new HashMap<String, Object>(){{put("msg", "Internal server error!");}}), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}