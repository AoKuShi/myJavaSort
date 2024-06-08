package mysort.sort;

public class InsertionSort<T extends Comparable> extends Sort<T> { // Sort(추상클래스)를 상속받은 InsertionSort 클래스를 생성

	@Override
	public void sort(T[] dataList) {
		setData(dataList); // Sort의 dataList객체를 생성

		for (int i = 1; i < sortedData.length; i++) { // sortedData의 인덱스 1부터 마지막까지 ++
			int loc = findLessFromLast(sortedData, sortedData[i], i - 1); // sortedData[i]와 i-1부터 0까지의 sortedData를 비교, sortedData[i]보다 같거나 작을 경우 해당 인덱스를 리턴, 없을 경우 -1을 리턴

			if (loc != i - 1) // i의 시작값은 1이기에 -1이 될 수 없음(findLessFromLast에서 -1을 리턴했을 때 스킵됨)
				insertData(sortedData, loc + 1, i); // 해당 인덱스의 뒤(loc+1)에 sortedData[i]를 넣고, 나머지를 하나씩 뒤로 정렬
		}

	}

	private void insertData(T[] dataList, int target, int source) {
		T temp = dataList[source]; // 인덱스 하나씩 뒤로 옮겨지기 전에 dataList[source]를 변수에 할당
		for (int i = source; i > target; i--) { // source부터 target까지 인덱스+1
			dataList[i] = dataList[i - 1];
		}
		dataList[target] = temp; // 할당된 값을 dataList[target]에 할당
	}

	private int findLessFromLast(T[] dataList, T data, int last) { //
		for (int i = last; i >= 0; i--) { // last부터 0까지 실행
			if (dataList[i].compareTo(data) <= 0)
				return i; // data가 sortedData[i]보다 같거나 작을 경우 해당 인덱스를 리턴
		}
		return -1; // 아닐 경우 -1을 리턴
	}

}
