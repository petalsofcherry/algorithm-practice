import java.util.*;

public class Main {
    public static void main(String[] args) {
        Sort.QuickSort quickSort = new Sort.QuickSort();
//        System.out.println(Arrays.toString(quickSort.sort(new int[]{3, 4, 5, 3, 1, 2, 1, 6})));
//        System.out.println(BianarySearch.search(new int[]{1, 1, 2, 3, 3, 4, 5, 6}, 4));
        System.out.println(-1 >>> 2);
    }
}

class Software {
    int ver;
    int id;
    List<Software> deps;

    boolean canInstall (Software s){
        // 判断循环依赖可以用双指针，一个一次走一步，一个一次走两个，假如在遇到null之      前碰到了那就说明有循环链表
        boolean isOk0 = isCircurList(s);

        //版本问题用数组把遇到的 software 都存下来，Map<id, ver>这样，每遇到一个新的dep就去map里看看有没有这个id，有的话再比较ver，不一样说明不可以Install
        boolean isOk1 = compareDepsVer(s);

        return isOk0 && isOk1;
    }

    boolean isCircurList(Software s) {

        return true;
    }



    boolean compareDepsVer(Software s) {
        List<Software> deps = s.deps;
        if (deps == null) return true;

        Map<Integer, Integer> softwares = new HashMap<>();
        for (Software dep : deps) {
            if (softwares.get(dep.id) != null && softwares.get(dep.id) != dep.ver)
                return false;
            compareDepsVer(dep);
        }
        return true;
    }

}




