/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.util;

import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.model.Condition;

/**
 *
 * @author sam
 */
public final class RuleNameParser {
    private RuleNameParser(){
        
    }
    public static String getParsedName(BranchItemRule rule){
        StringBuilder htmlRuleTitle=new StringBuilder();
        htmlRuleTitle.append(parseConditionName(rule.getCondition()));
        htmlRuleTitle.append(" ");
        htmlRuleTitle.append(parseResultName(rule));
        return htmlRuleTitle.toString();
    }
    
    private static String parseResultName(BranchItemRule rule) {
        StringBuilder sb = new StringBuilder();
        if (rule.getRuletype() == 1) {
            try {
                int index = rule.getRulename().indexOf("this");
                sb.append(rule.getRulename().substring(index));
                sb.append("<span class='show'>");
                sb.append("</span>");
            } catch (Exception e) {
                e.getStackTrace();
            }
        } else {
            int index = rule.getRulename().indexOf("this");
            sb.append(rule.getRulename().substring(index));
        }
        return sb.toString();
    }
    
    private static String parseConditionName(Condition condition){
        Integer conditionType=condition.getConditionType();
        StringBuilder conditionTitle=new StringBuilder();
        if(conditionType==1){
            conditionTitle.append("If the user ");
            conditionTitle.append("<span id='answer'>");
            conditionTitle.append("answers, ");
            conditionTitle.append("</span> ");
        }else if(conditionType==2){
            conditionTitle.append("If the user ");
            conditionTitle.append("<span id='skip'>");
            conditionTitle.append("skips, ");
            conditionTitle.append("</span> ");
        }else if(conditionType==3){
            conditionTitle.append("If the user ");
            conditionTitle.append("<span id='property'>");
            conditionTitle.append("rating, ");
            conditionTitle.append("</span>");
            conditionTitle.append("<span class='comparator '>");
            conditionTitle.append(condition.getComparator());
            conditionTitle.append(" </span>");
        }else if(conditionType==4){
            conditionTitle.append("If <span class='property'>answers</span> meet certain expectation(s), ");
        }else if(conditionType==5){
            conditionTitle.append("If <span class='property'>sub questions</span> and <span class='property'>column choices</span> meet certain expectation(s), ");
        }
        return conditionTitle.toString();
    }
    
}
