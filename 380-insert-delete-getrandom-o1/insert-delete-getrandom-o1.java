class RandomizedSet {
    HashSet<Integer> st;
    ArrayList<Integer> arr;
    Random rand;
    public RandomizedSet() {
        st = new HashSet<>();
        arr=new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(st.contains(val)){
            return false;
        }
        st.add(val);
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!st.contains(val)){
            return false;
        }
        st.remove(val);
        arr.remove(Integer.valueOf(val));
        return true;
    }
    
    public int getRandom() {
        int indx = rand.nextInt(arr.size());
        return arr.get(indx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */