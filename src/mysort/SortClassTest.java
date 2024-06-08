package mysort;

import mysort.sort.BubbleSort;
import mysort.sort.InsertionSort;
import mysort.sort.MergeSort;
import mysort.sort.QuickSort;
import mysort.sort.SelectionSort;
import mysort.sort.Sort;

public class SortClassTest {

	public static void main(String[] args) {
		//Integer[] dataList = {5, 21, 14, 3, 31, 8, 27, 15}; // 오리지널 데이터 배열 인풋
		//String[] dataList = {"xxx", "ab", "bc", "ac"};
		Double[] dataList = {5.15, 2.33, 4.25, 1.11};
		sortData(dataList); // 오리지널 데이터를 넣어 sortData메서드 실행
	}
	
	static <T> void sortData(T[] dataList) {
		Sort sort; // sort 객체 생성
		
		sort = new SelectionSort(); // 선택 정렬 객체 생성
		sort.sort(dataList); // 오리지널 데이터(배열)를 넣어 실행
		System.out.printf("%-20s %s\n", "Input Data", sort.getOrgData()); // 오리지널 데이터
		System.out.printf("%-20s %s\n", sort.getClass().getSimpleName() + " Result", sort.getSortedData());
		System.out.println();
		
		sort = new InsertionSort(); // 삽입 정렬 객체 생성
		sort.sort(dataList); // 오리지널 데이터(배열)를 넣어 실행
		System.out.printf("%-20s %s\n", "Input Data", sort.getOrgData()); // 오리지널 데이터
		System.out.printf("%-20s %s\n", sort.getClass().getSimpleName() + " Result", sort.getSortedData()); // 정렬한 데이터
		System.out.println();
		
		sort = new BubbleSort(); // 버블 정렬 객체 생성
		sort.sort(dataList); // 오리지널 데이터(배열)를 넣어 실행
		System.out.printf("%-20s %s\n", "Input Data", sort.getOrgData()); // 오리지널 데이터
		System.out.printf("%-20s %s\n", sort.getClass().getSimpleName() + " Result", sort.getSortedData()); // 정렬한 데이터
		System.out.println();
		
		sort = new MergeSort(); // 병합(머지) 정렬 객체 생성
		sort.sort(dataList); // 오리지널 데이터(배열)를 넣어 실행
		System.out.printf("%-20s %s\n", "Input Data", sort.getOrgData()); // 오리지널 데이터
		System.out.printf("%-20s %s\n", sort.getClass().getSimpleName() + " Result", sort.getSortedData()); // 정렬한 데이터
		System.out.println();
		
		sort = new QuickSort(); // 퀵 정렬 객체 생성
		sort.sort(dataList); // 오리지널 데이터(배열)를 넣어 실행
		System.out.printf("%-20s %s\n", "Input Data", sort.getOrgData()); // 오리지널 데이터
		System.out.printf("%-20s %s\n", sort.getClass().getSimpleName() + " Result", sort.getSortedData()); // 정렬한 데이터
		System.out.println();	
	}
}
