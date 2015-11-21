/**
 * @author Willie Ausrotas, Brian Lee
 * Student Number: 7804922, 7938501
 * Assignment: 4, Q3
 * Section: ITI1121-A
 */

public class Transaction {

    private int shares;
    private float sharePrice;

    public Transaction( int shares, float sharePrice ) {
	this.shares = shares;
	this.sharePrice = sharePrice;
    }

    public int getShares() {
	return shares;
    }

    public void sell( int num ) {
	if ( num > shares ) {
	    throw new IllegalArgumentException( "can't sell more than you have" );
	}
	    shares = shares - num;
    }

    public float getSharePrice() {
	return sharePrice;
    }

}