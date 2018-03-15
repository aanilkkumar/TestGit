package com.globallogic.report.billing.service;

import com.globallogic.report.billing.domain.PredictionResponse;

import java.text.ParseException;
import java.util.Date;
/**
 * Created by sunny on 15/03/18.
 */
public interface PredictionService {
    PredictionResponse getBillPrediction(Date day) throws ParseException;

}
