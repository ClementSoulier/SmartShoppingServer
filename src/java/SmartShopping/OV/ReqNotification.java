/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartShopping.OV;

/**
 *
 * @author TheNabo1
 */
public class ReqNotification extends OVReq {
 
    
    private OVNotification ovNotification;

    public OVNotification getOvNotification() {
        return ovNotification;
    }

    public void setOvNotification(OVNotification ovNotification) {
        this.ovNotification = ovNotification;
    }
    
}
