package com.globallogic.report.billing.rest;


import com.globallogic.report.billing.constants.BillingConstant;
import com.globallogic.report.billing.domain.PredictionResponse;
import com.globallogic.report.billing.service.PredictionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by sunny on 15/03/18.
 */
@RestController
@RequestMapping("/app")
public class BillingController {
    private final static Logger LOGGER = Logger.getLogger(BillingController.class.getName());

    @Autowired
    PredictionService predictionService;

    @ApiOperation(value = "View the bill prediction", response = PredictionResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the bill for next month"),
            @ApiResponse(code = 400, message = "Date format is incorrect. Please provide in dd-MMM-yyyy format"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/bill")
    public ResponseEntity getBillPrediction(@RequestParam String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(BillingConstant.DATE_FORMAT);
        try{
            Date parsedDate = sdf.parse(date);
            PredictionResponse response = predictionService.getBillPrediction(parsedDate);
            if(response == null) {
                LOGGER.info(BillingConstant.DATA_NOT_AVAILABLE);
                return ResponseEntity.ok(BillingConstant.DATA_NOT_AVAILABLE);
            }
            return ResponseEntity.ok(response.toString());
        }catch (ParseException e){
            return ResponseEntity.badRequest().body(BillingConstant.INCORRECT_DATE_FORMAT);
        }


    }


}
