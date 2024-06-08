package mysort.sort;

import java.lang.reflect.Array;

public class MergeSort<T extends Comparable> extends Sort<T> { // Sort(추상클래스)를 상속받은 MergeSort 클래스를 생성

	@Override
	public void sort(T[] dataList) {
		setData(dataList); // Sort의 dataList객체를 생성
		mergeSort(sortedData, 0, sortedData.length - 1);
	}

	void mergeSort(T[] dataList, int start, int end) {
		if (start >= end) // 배열이 하나의 요소만 가지고 있는 경우 종료
			return; 

		int mid = (start + end) / 2; // 배열을 반으로 분할하기 위한 중간 인덱스 계산
		mergeSort(dataList, start, mid); // 왼쪽 부분 배열에 대한 재귀 호출, 하나의 요소의 배열이 들어가게 되면 종료되고 연산이 시작됨
		mergeSort(dataList, mid + 1, end); // 오른쪽 부분 배열에 대한 재귀 호출, 하나의 요소의 배열이 들어가게 되면 종료되고 연산이 시작됨
		merge(dataList, start, mid, end); // 분할된 배열을 병합
	}

	void merge(T[] dataList, int start, int mid, int end) {
		T[] tempList = (T[]) Array.newInstance(dataList.getClass().getComponentType(), end - start + 1);

		int i = start, j = mid + 1, k = 0; // i는 왼쪽 부분 배열의 시작 인덱스, j는 오른쪽 부분 배열의 시작 인덱스, k는 임시 배열의 인덱스

		while (i <= mid && j <= end) { // 두 부분 배열을 비교하여 임시 배열에 병합
			if (dataList[i].compareTo(dataList[j]) <= 0)
				tempList[k++] = dataList[i++];
			else
				tempList[k++] = dataList[j++];
		}

		while (i <= mid)
			tempList[k++] = dataList[i++]; // 왼쪽 부분 배열이 남은 경우 복사

		while (j <= end)
			tempList[k++] = dataList[j++]; // 오른쪽 부분 배열이 남은 경우 복사

		for (i = start, k = 0; k < tempList.length; i++, k++) // 임시 배열의 내용을 원래 배열에 복사
			dataList[i] = tempList[k];
	}

}
