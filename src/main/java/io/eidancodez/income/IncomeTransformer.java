package io.eidancodez.income;

import java.time.LocalDate;

public class IncomeTransformer {
    
    public static IncomeModel transformToModel(IncomeDTO dto){
        IncomeModel model = new IncomeModel();
        model.setId(Integer.parseInt(dto.getId()));
        model.setAmount(Integer.parseInt(dto.getAmount()));
        model.setPayer(dto.getPayer());
        model.setDescription(dto.getDescription());
        model.setDate(LocalDate.parse(dto.getDate()));
        return model;
    }

    public static IncomeDTO transformToDTO(IncomeModel model){
        IncomeDTO dto = new IncomeDTO();
        dto.setId(model.getId().toString());
        dto.setAmount(model.getAmount().toString());
        dto.setPayer(model.getPayer());
        dto.setDate(model.getDate().toString());
        dto.setDescription(model.getDescription());
        return dto;
    }
}
