package it.softre.thip.base.firmadigitale;

import java.sql.SQLException;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.*;

public class DocumentiAttesaFirma extends DocumentiAttesaFirmaPO {

	public ErrorMessage checkDelete() {
		return null;
	}
	
	public int save() throws SQLException {
        if (!isOnDB()) {
            try {
                setId(new Integer(Numerator.getNextInt("DocumentiAttesaFirma")));
            } catch (NumeratorException e) {
                e.printStackTrace(Trace.excStream);
            }
        }
        return super.save();
    }

}

