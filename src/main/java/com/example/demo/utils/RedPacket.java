package com.example.demo.utils;

import java.util.*;

public class RedPacket {
    // 线段切割法代码实现：(jkd1.8)
    public static List<Integer> divideRedPacket(int totalAmount, int totalPeopleCount) {
        List<Integer> redPackets = new ArrayList<>();
        //承装切割点
        Set<Integer> cutPoints = new TreeSet<>((front, back) -> front - back);
        Random createAmount = new Random();
        //切割n-1次，且保证每次割点不相同
        while (cutPoints.size() != totalPeopleCount - 1) {
            //这样操作的目的是random是左闭右开,有可能取到0，所以随机范围[1,剩余金额
            int currentCutPoint = createAmount.nextInt(totalAmount) + 1;
            cutPoints.add(currentCutPoint);
        }
        int preCutPoint = 0;
        //按照切割点来算金额
        for (int currentCutPoint : cutPoints) {
            int currentAmount = currentCutPoint - preCutPoint;
            preCutPoint = currentCutPoint;
            redPackets.add(currentAmount);
        }
        //最后一次获取所有的金额，保证总金额等于totalAmount
        redPackets.add(totalAmount - preCutPoint);
        return redPackets;
    }
}
