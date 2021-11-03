package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LowestCommonManager {

   public ReportTo findLowestCommonManager(ReportTo topNode, String firstReportee, String secondReportee) {
      if(topNode == null)
         return null;

      ReportTo lowest = findLowest(topNode, topNode.reportees, firstReportee, secondReportee);

      return lowest;
   }

   private ReportTo findLowest(ReportTo parentNode, List<ReportTo> reportees, String firstReportee, String secondReportee) {
      if(reportees == null || reportees.isEmpty()) {
        parentNode.match = parentNode.label.equalsIgnoreCase(firstReportee) || parentNode.label.equalsIgnoreCase(secondReportee) ? parentNode.match + 1 : parentNode.match;
        return null;
      }
      else{
         for(ReportTo reportee : reportees){
            findLowest(reportee, reportee.reportees, firstReportee, secondReportee);
            parentNode.match += reportee.match;
         }
      }
      if(parentNode.match == 2)
         return parentNode;
      return null;
   }

   public static void main(String[] args) {
      LowestCommonManager obj = new LowestCommonManager();
      System.out.println(obj.findLowestCommonManager(obj.topNode, "O", "Q"));
   }

   private ReportTo topNode;
   public LowestCommonManager(){
      topNode = new ReportTo("A", null);
      createStructure(topNode);
   }

   public class ReportTo{
      String label;
      int match;
      List<ReportTo> reportees;

      public ReportTo(String label, List<ReportTo> reportees){
         this.label = label;
         this.reportees = reportees;
      }
   }

   private void createStructure(ReportTo topNode) {
      addReportees(topNode, Arrays.asList(new String[]{"B", "C", "D", "E", "F"}));
      final ReportTo b = topNode.reportees.get(0);
      addReportees(b, Arrays.asList(new String[]{"G","H","I"}));
      final ReportTo c = topNode.reportees.get(1);
      addReportees(c, Arrays.asList(new String[]{"J", "K"}));
      final ReportTo e = topNode.reportees.get(3);
      addReportees(e, Arrays.asList(new String[]{"L", "M"}));
      final ReportTo f = topNode.reportees.get(4);
      addReportees(f, Arrays.asList(new String[]{"N"}));
      final ReportTo g = b.reportees.get(0);
      addReportees(g, Arrays.asList(new String[]{"O", "P", "Q"}));
      final ReportTo j = c.reportees.get(0);
      addReportees(j, Arrays.asList(new String[]{"R"}));
      final ReportTo l = e.reportees.get(0);
      addReportees(l, Arrays.asList(new String[]{"S","T","U","V"}));
      final ReportTo s = l.reportees.get(0);
      addReportees(s, Arrays.asList(new String[]{"Z"}));
      final ReportTo r = j.reportees.get(0);
      addReportees(r, Arrays.asList(new String[]{"W"}));
      final ReportTo w = r.reportees.get(0);
      addReportees(w, Arrays.asList(new String[]{"X","Y"}));
   }

   private void addReportees(ReportTo node, List<String> asList) {
      List<ReportTo> reportees = new ArrayList<>();
      for(String s : asList){
         ReportTo reportee = new ReportTo(s, null);
         reportees.add(reportee);
      }
      node.reportees = reportees;
   }

}
