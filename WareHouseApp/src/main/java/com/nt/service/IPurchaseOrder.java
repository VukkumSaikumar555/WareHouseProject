package com.nt.service;

import java.util.List;

import com.nt.model.PurchaseOrder;

public interface IPurchaseOrder {
      public PurchaseOrder savePO(PurchaseOrder po);
      public List<PurchaseOrder> getAllRecord();
      public PurchaseOrder getPurchaseOrder(Integer id);
}
