package org.totschnig.myexpenses.dialog;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import androidx.annotation.NonNull;

import org.totschnig.myexpenses.R;

public abstract class TextSourceDialogFragment extends
    ImportSourceDialogFragment implements OnCheckedChangeListener {
  protected CheckBox mImportCategories;
  protected CheckBox mImportParties;
  protected CheckBox mImportTransactions;

  public TextSourceDialogFragment() {
    super();
  }
  @Override
  protected void setupDialogView(@NonNull View view) {
    super.setupDialogView(view);
  
    mImportCategories = view.findViewById(R.id.import_select_categories);
    if (mImportCategories != null) {
      mImportCategories.setOnCheckedChangeListener(this);
      mImportParties = view.findViewById(R.id.import_select_parties);
      mImportParties.setOnCheckedChangeListener(this);
      mImportTransactions = view.findViewById(R.id.import_select_transactions);
      mImportTransactions.setOnCheckedChangeListener(this);
    }
  }
  @Override
  protected boolean isReady() {
    if (super.isReady()) {
      return (mImportCategories.getVisibility() == View.VISIBLE && mImportCategories.isChecked()) ||
          (mImportParties.getVisibility() == View.VISIBLE && mImportParties.isChecked()) ||
          (mImportTransactions.getVisibility() == View.VISIBLE && mImportTransactions.isChecked());
    } else {
      return false;
    }
  }
  @Override
  public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
    setButtonState();
  }
}