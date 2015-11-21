/**
 * @author Willie Ausrotas, Brian Lee
 * Student Number: 7804922, 7938501
 * Assignment: 4, Q3
 * Section: ITI1121-A
 */

public class JStock {
	// Instance variables
	private Queue<Transaction> shares;

	public JStock() {
		shares = new LinkedQueue<Transaction>();
	}

	/**
	 * This method allows you to buy stocks and will add them into the queue
	 * 
	 * @param num
	 *            - The amount of shares that are being bought
	 * @param sharePrice
	 *            - The amount paid for the shares
	 */
	public void buy(int num, float sharePrice) {
		Transaction t = new Transaction(num, sharePrice);
		shares.enqueue(t);

	}

	/**
	 * This method will sell the stocks, taking the stocks that were bought
	 * first and moving to the most recent stocks. Also updates the value of
	 * capital, which is the overall money made by selling all stocks.
	 * 
	 * @param num
	 *            - Number of stocks to be sold
	 * @param sharePrice
	 *            - The current price of the stocks
	 * @return currentCapital
	 * 				- Returns the amount of money gained/lost on the
	 *         			trades.
	 */
	public float sell(int num, float sharePrice) {
		if (shares.isEmpty()) {
			throw new EmptyQueueException(); //Initial check to make sure Queue is not empty
		}
		float currentCapital = 0;
		while (num != 0 && !shares.isEmpty()) { //Keep running until all stocks that need to be sold are sold.
			int amountOfShares; //Amount of shares being sold
			float priceOfShares; //The price we are selling them at.
			Transaction t = shares.dequeue(); //Making a temp transaction to use in calculations.
			if (t.getShares() > num) { //If you have more shares bought at one price, then being sold:
				amountOfShares = num; //Set amount of shares to be sold.
				Transaction temp = new Transaction((t.getShares() - num), //Adds a new transaction with the remaining
						t.getSharePrice());  //Amount of stocks that are not to be sold yet.
				shares.enqueue(temp); //Requeue the rest of stocks.
				num = 0;
			} else { //If we are selling all shares in this position in queue:
				amountOfShares = t.getShares(); //Get the amount of shares we have already dequeued.
				num -= amountOfShares; //Reduce the amount of shares left to be sold.
			}
			priceOfShares = t.getSharePrice(); //Get the price of the shares
			currentCapital += amountOfShares * (sharePrice - priceOfShares); //Increase the currentCapital gain/loss you currently have.
		}
		return currentCapital; //return your capital value.
	}

	/**
	 * This method will calculate the total value of
	 * your portfolio with the prices you paid for the shares.
	 * @return the total value of all money you have made or lost.
	 */
	public float getValue() {
		float value = 0;
		Queue<Transaction> temp = new LinkedQueue<>(); //Temp queue to keep all dequeued elements.
		while (!shares.isEmpty()) {
			Transaction t = shares.dequeue(); //Dequeue the first transaction from the portfolio
			value += t.getSharePrice() * t.getShares(); //Calculate the total value of shares.
			temp.enqueue(t); //Requeue the shares into the temp queue
		}
		while(!temp.isEmpty())
		{
			shares.enqueue(temp.dequeue()); //Requeue all the shares back into the original queue.
		}
		return value; //Return the total value of all shares you own.
	}

}
