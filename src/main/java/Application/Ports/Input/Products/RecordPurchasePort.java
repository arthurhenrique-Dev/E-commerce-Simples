package Application.Ports.Input.Products;

import Application.DTOs.Products.DTORecordPurchase;

import java.util.UUID;

public interface RecordPurchasePort {
    
    void RecordPurchase(DTORecordPurchase dtoRecordPurchase);
}
