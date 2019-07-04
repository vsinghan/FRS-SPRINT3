package com.cg.flightreservationsystem.dto;

public class TicketDTO {

	private String pnrNo;
//	private String passengerId;
//	private String flightId;
//	private String aeroplaneId;
//	private String seatNo;

	public TicketDTO(String pnrNo) {
		super();
		this.pnrNo = pnrNo;
	}

	public TicketDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}

	@Override
	public String toString() {
		return "TicketDTO [pnrNo=" + pnrNo + "]";
	}
}
