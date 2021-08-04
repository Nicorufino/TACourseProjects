package com.solvd.socialNetwork.trends;

import com.solvd.socialNetwork.Region;

public class RegionTrends extends Trends{
    private Region trendRegion;

    public Region getTrendRegion() {
        return trendRegion;
    }

    public void setTrendRegion(Region trendRegion) {
        this.trendRegion = trendRegion;
    }

    public void showOnlyInRegion(){}
}
