package com.tiker.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatusEnum {
    DRAFT_ORDER(0,"Draft order"),
    NEW_ORDER(1,"Newly created order"),
    ACCEPTED_ORDER(2, "Accepted order"),
    COMPlETE_ORDER(3, "Complete order"),
    FINISHED_ORDER(4, "Finished order"),
    GIVE_UP_ORDER(9, "Give up order"),
    CANCEL_ORDER(8, "Cancel order"),
    ARGUMENT_ORDER(7, "Argument order");

    int statusCode;
    String statusDescription;
}
