package org.jfrog.eclipse.ui.licenses;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.jfrog.eclipse.ui.ComponentDetails;

/**
 * @author yahavi
 */
public class LicensesTab extends CTabItem {

	public LicensesTab(CTabFolder parent) {
		super(parent, SWT.NONE);
		setText("Licenses Info");
		SashForm horizontalDivision = new SashForm(parent, SWT.HORIZONTAL);

		// Left
		LicensesTree.createLicensesTree(horizontalDivision);

		// Right
		ComponentDetails componentDetails = new ComponentLicenseDetails(horizontalDivision);

		LicensesTree licensesTree = LicensesTree.getLicensesTree();
		licensesTree.setComponentDetails(componentDetails);
		licensesTree.registerListeners();
		horizontalDivision.setWeights(new int[] { 1, 2 });
		setControl(horizontalDivision);
	}
	
	@Override
	public void dispose() {
		LicensesTree.disposeTree();
		super.dispose();
	}
}