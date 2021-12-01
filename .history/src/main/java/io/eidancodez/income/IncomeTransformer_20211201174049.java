package io.eidancodez.income;

import java.time.LocalDate;

public class IncomeTransformer {
    
    public IncomeModel transformToModel(IncomeDTO dto){
        IncomeModel model = new IncomeModel();
        model.setId(Integer.parseInt(dto.getId()));
        model.setAmount(Integer.parseInt(dto.getAmount()));
        model.setPayer(dto.getPayer());
        model.setDescription(dto.getDescription());
        model.setDate(LocalDate.parse(dto.getDate()));
        return null;
    }
}
