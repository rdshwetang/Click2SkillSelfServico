/* 
 * @author Shwetang R.D 
 * Visual Sistemas Electronicos Ltda.
 * Belo Horizonte-Brazil -2014
 */
package com.dribblelogics.c2s.adapters;
public class ThreeTextOneImageAdapterItems {
    public int icon;
    public String title1,title2,title3;
    public ThreeTextOneImageAdapterItems(){
        super();
    }
   
    public ThreeTextOneImageAdapterItems(int icon, String title1,String title2, String title3) {
        super();
        this.icon = icon;
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
    }
}