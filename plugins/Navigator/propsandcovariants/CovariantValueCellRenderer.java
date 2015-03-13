package propsandcovariants;

import propsandcovariants.SinglePropertyOrGroup;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import org.micromanager.utils.ReportingUtils;
import org.micromanager.utils.SliderPanel;
import propsandcovariants.DeviceControlTableModel;

public class CovariantValueCellRenderer implements TableCellRenderer {
   // This method is called each time a cell in a column
   // using this renderer needs to be rendered.

   JLabel lab_ = new JLabel();

   public CovariantValueCellRenderer() {
      super();
   }


   @Override
   public Component getTableCellRendererComponent(JTable table, Object value,
           boolean isSelected, boolean hasFocus, int rowIndex, int colIndex) {

      CovariantPairValuesTableModel data = (CovariantPairValuesTableModel) table.getModel();       
      Covariant cv = colIndex == 0 ?  data.getPairing().getIndependentCovariant() : data.getPairing().getDependentCovariant();

      lab_.setOpaque(true);
      lab_.setHorizontalAlignment(JLabel.LEFT);
      Component comp;
      
//      if (cv.hasLimits()) {
//         SliderPanel slider = new SliderPanel();
//         if (cv.getType() == CovariantType.INT) {
//            slider.setLimits(cv.getLowerLimit().intValue(), cv.getUpperLimit().intValue());
//         } else {
//            slider.setLimits(cv.getLowerLimit().doubleValue(), cv.getUpperLimit().doubleValue());
//         }
//         try {
//            slider.setText(((CovariantValue) value).toString());
//         } catch (ParseException ex) {
//            ReportingUtils.logError(ex);
//         }
//         slider.setToolTipText(data.getPairing().getValue(colIndex, rowIndex).toString());
//         comp = slider;
//      } else {
      try {
         lab_.setText(data.getPairing().getValue(colIndex, rowIndex).toString());
         comp = lab_;

//      }
      
//      if (pair_.readOnly) {
//         comp.setBackground(Color.LIGHT_GRAY);
//      } else {
         comp.setBackground(Color.WHITE);
//      }

      } catch (Exception e) {
         System.out.println();
         throw new RuntimeException();
      }
      return comp;
   }

   // The following methods override the defaults for performance reasons
   public void validate() {
   }

   public void revalidate() {
   }

   protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
   }

   public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
   }
}