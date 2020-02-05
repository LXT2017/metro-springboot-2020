package com.mt.metro.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/charge")
@AllArgsConstructor
public class ChargeController {
/*
    @PostMapping("/startCharge")
    @CacheLock(prefix = "recharge")
    public ResponseResult startCharge(@RequestBody @Validated({ChargeQuery.QRCodeNotBlank.class}) ChargeQuery query){
        return this.chargeChargeService.startCharge(query);
    }*/
}