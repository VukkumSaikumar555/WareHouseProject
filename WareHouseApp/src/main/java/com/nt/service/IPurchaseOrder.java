package com.nt.service;

import java.util.List;

import com.nt.model.PurchaseDtl;
import com.nt.model.PurchaseOrder;

public interface IPurchaseOrder {
      public PurchaseOrder savePO(PurchaseOrder po);
      public List<PurchaseOrder> getAllRecord();
      public PurchaseOrder getPurchaseOrder(Integer id);
      
      //Screen 2 
      public Integer addParts(PurchaseDtl dtl);
      public List<PurchaseDtl> getPurchaseDtlByOrderId(Integer id);

}
