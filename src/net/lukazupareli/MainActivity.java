package net.lukazupareli;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.accounts.AccountManager;
import android.accounts.Account;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;


public class MainActivity extends Activity {
    private TextView message;
    private Button button;
    private AccountManager manager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        message = (TextView) findViewById(R.id.scratchText);
        button = (Button) findViewById(R.id.button);
        manager = (AccountManager) getSystemService(ACCOUNT_SERVICE);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showAccounts();
            }
        });

        showAccounts();
    }

    private void showAccounts() {
        final Account[] accounts = manager.getAccounts();

        message.setText("Accounts:\n");

        for (Account account: accounts) {
            Log.d("SCRATCH", account.name);
            message.append(account.name + "\n");
        }

        Log.d("SCRATCH", Integer.toString(accounts.length));
    }
}
