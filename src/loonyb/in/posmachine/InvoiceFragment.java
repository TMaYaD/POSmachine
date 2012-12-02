/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package loonyb.in.posmachine;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class InvoiceFragment extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {

        // If activity recreated (such as from screen rotate), restore
        // the previous invoice selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.invoice_view, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the invoice text.
        Bundle args = getArguments();
        if (args != null) {
            // Set invoice based on argument passed in
            updateInvoiceView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set invoice based on saved instance state defined during onCreateView
            updateInvoiceView(mCurrentPosition);
        }
    }

    public void updateInvoiceView(int position) {
    	Context c = getActivity();

    	TableLayout table = (TableLayout) getActivity().findViewById(R.id.items);
    	table.addView(itemsHeader());

    	// TODO: load invoice from database
    	Invoice invoice = Ipsum.Invoices[position];
    	for( int i = 0; i < invoice.items.length; i++ ) {
    		table.addView(invoice.items[i].buildRow(c, i));
    	}
        mCurrentPosition = position;
    }

    private TableRow itemsHeader() {
    	Context c = getActivity();
    	Resources res = getResources();
    	String[] headers = res.getStringArray(R.array.item_header);
    	
    	TableRow row = new TableRow(c);

    	for( int i = 0; i < headers.length; i++) {
    		TextView column = new TextView(c);
    		column.setText(headers[i]);
        	row.addView(column);
    	}
    	
		return row;
	}

	@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current invoice selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}