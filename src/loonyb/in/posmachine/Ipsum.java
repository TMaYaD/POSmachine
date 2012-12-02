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

public class Ipsum {

    static String[] Customers = {
        "Invoice One",
        "Invoice Two"
    };

    static Invoice[] Invoices = {
    	new Invoice( new InvoiceItem[]{
        		new InvoiceItem("Product 1", 10, 12.4),
        		new InvoiceItem("Product 2", 24, 123.1, 10)
    	}),
    	new Invoice( new InvoiceItem[]{
    			new InvoiceItem("Product 3", 13, 12.24),
            	new InvoiceItem("Product 4", 242, 12.1, 10)
        })
    };
}
