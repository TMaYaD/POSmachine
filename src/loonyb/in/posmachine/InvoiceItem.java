package loonyb.in.posmachine;

import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

public class InvoiceItem {
	String productName;
	int quantity;
	double price;
	double discount;
	
	InvoiceItem(String productName, int quantity, double price, double discount) {
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
	}

	InvoiceItem(String productName, int quantity, double price) {
		this(productName, quantity, price, 0);
	}

	public TableRow buildRow(Context c, int index) {
    	TableRow row = new TableRow(c);

    	TextView s_no = new TextView(c);
    	s_no.setText(index+"");
        row.addView(s_no);
    	
        TextView productNameCell = new TextView(c);
    	productNameCell.setText(productName);
        row.addView(productNameCell);
    	
        EditText quantityCell = new EditText(c);
    	quantityCell.setText(quantity+"");
    	quantityCell.setInputType(InputType.TYPE_CLASS_NUMBER);
        row.addView(quantityCell);
    	
        TextView priceCell = new TextView(c);
    	priceCell.setText(price+"");
        row.addView(priceCell);
    	
        EditText discountCell = new EditText(c);
    	discountCell.setText(discount+"");
    	discountCell.setInputType(InputType.TYPE_CLASS_NUMBER);
        row.addView(discountCell);
    	
		return row;
	}
}
