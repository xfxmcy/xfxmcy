package com.xfxmcy.client.print;

import java.util.List;

import com.xfxmcy.component.RepairConstant;
import com.xfxmcy.pojo.Menu;

/**
 * @author CY
 * @Date   26-07	
 * @description print menu constructor  by main method 
 * @version		0.0.1 SNAPSHOT
 */
public class TestMenuConstructor {
	
	public static void main(String[] args) {
		
		RepairConstant repairConstant = new RepairConstant();
		List<Menu> menu = repairConstant.getMenuList();
		forEachMenu(menu , null , "");
	}

	private static void forEachMenu(List<Menu> menu ,String pid , String oper) {
	
		
		for (int i = 0; i < menu.size(); i++) {
			if (null == pid) {
				if(null == menu.get(i).getMenu() ){
					System.out.println(menu.get(i).getId()+" " + oper + menu.get(i).getText());	
					
					forEachMenu(menu, menu.get(i).getId(), oper+ "\t");
				}
			}
			else{
				if(null != menu.get(i).getMenu()){
					if(pid.equals(menu.get(i).getMenu().getId())){
						System.out.println(menu.get(i).getId()+" " + oper + menu.get(i).getText());
						forEachMenu(menu, menu.get(i).getId(), oper+ "\t");
					}
				}	
			}
		}
	}
}
