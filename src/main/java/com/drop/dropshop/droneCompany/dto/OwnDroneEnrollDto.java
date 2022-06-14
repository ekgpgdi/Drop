package com.drop.dropshop.droneCompany.dto;

import com.drop.dropshop.droneCompany.entity.CompanyDroneDetail;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class OwnDroneEnrollDto {
    @ApiModelProperty(example = "드론 모델을 식별하는 uuid")
    private final UUID modelId;
    @ApiModelProperty(example = "드론 배송 기본 가격")
    private final int basePrice;
    @ApiModelProperty(example = "동일 모델 보유 드론 대수")
    private final int num;
    @ApiModelProperty(example = "동일 모델 운행 가능 드론 대수")
    private final int operableNum;
    @ApiModelProperty(example = "상세 드론 리스트")
    private final List<DroneDetailDto> companyDroneDetailList;
}
