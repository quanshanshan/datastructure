package com.opentext.ecd.dctm.test.controller;

import lombok.Data;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opentext.ecd.dctm.test.animal.Dog;
import com.opentext.ecd.dctm.test.animal.EatService;
import com.opentext.ecd.dctm.test.animal.SingleTon;

@RestController
public class DataBaseController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;  
  
    
    @Autowired
    DataSource source;    
    
    @Data
    static class Result {
        private final int left;
        private final int right;
        private final long answer;
    }

    // SQL sample
    @RequestMapping("calc")
    Result calc(@RequestParam int left, @RequestParam int right) {
        MapSqlParameterSource source = new MapSqlParameterSource()
                .addValue("left", left)
                .addValue("right", right);
        return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
                (rs, rowNum) -> new Result(left, right, rs.getLong("answer")));
    }
   
    
    @RequestMapping("/jdbc")
    String getusername() {
		return source.toString();
    	
    }
    
}
