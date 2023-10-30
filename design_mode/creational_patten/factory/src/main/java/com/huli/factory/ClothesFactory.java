package com.huli.factory;

import com.huli.interfaces.Clothes;
import com.huli.interfaces.impl.Cap;
import com.huli.interfaces.impl.Overcoat;

public class ClothesFactory {

    public Clothes getClothes(String clothesName){

        if (clothesName == null){
            return null;
        }
        if (clothesName.equalsIgnoreCase("cap")){
            return new Cap();
        }else if (clothesName.equalsIgnoreCase("overcoat")){
            return new Overcoat();
        }
        return null;
    }

}
