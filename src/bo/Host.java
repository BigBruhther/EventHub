/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.security.Timestamp;
/**
 *
 * @author Kohner Smith
 */
public class Host {
    private int hostId;
    private Timestamp startDate;

    public Host(int hostId, Timestamp startDate) {
        this.hostId = hostId;
        this.startDate = startDate;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }
    
}
