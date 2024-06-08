package mysort.sort;


public class QuickSort<T extends Comparable> extends Sort<T> { // Sort 추상클래스를 상속받아 QuickSort 클래스를 생성

	@Override
	public void sort(T[] dataList) {
		setData(dataList); // Sort의 dataList객체를 생성
		quickSort(sortedData, 0, sortedData.length - 1);
	}

	// 실제 퀵 정렬 알고리즘을 수행하는 메서드
	void quickSort(T[] dataList, int start, int end) {
		if (start >= end) // 배열이 하나의 요소만 가지고 있는 경우 종료
			return;

		int p = partition(dataList, start, end); // partition 메서드를 호출하여 피벗 위치를 얻음

		quickSort(dataList, start, p - 1); // 피벗 왼쪽 부분을 재귀적으로 정렬
		quickSort(dataList, p + 1, end); // 피벗 오른쪽 부분을 재귀적으로 정렬
	}

	
	int partition(T[] dataList, int start, int end) { // 배열을 분할하고 피벗의 최종 위치를 반환
		T pivot = dataList[end]; // 마지막 요소를 피벗으로 설정
		int leftEnd = start - 1; // 왼쪽 부분의 끝 인덱스를 초기화
		for (int i = start; i <= end - 1; i++) { // 시작부터 끝 - 1까지 반복
			if (dataList[i].compareTo(pivot) < 0) { // 현재 요소가 피벗보다 작으면
				swap(dataList, ++leftEnd, i); // leftEnd를 증가시키고 현재 요소와 스왑
			}
		}
		swap(dataList, leftEnd + 1, end); // 피벗을 올바른 위치로 이동
		return leftEnd + 1; // 피벗의 최종 위치를 반환
	}

}
