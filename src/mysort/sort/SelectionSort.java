package mysort.sort;

public class SelectionSort<T extends Comparable> extends Sort<T> { // Sort(추상클래스)를 상속받은 SelectionSort 클래스를 생성

	@Override
	public void sort(T[] dataList) {
		setData(dataList); // Sort의 dataList객체를 생성

		int maxIndex; // maxIndex 변수 생성
		for (int last = sortedData.length - 1; last >= 1; last--) { // 마지막 인덱스(last)에서 시작, 배치 시 last -1
			maxIndex = selectMax(sortedData, last); // selectMax 메서드를 실행, sortedData[0]부터 sortedData[last]까지의 값 중 최대값을 가지는 값의 인덱스를 maxIndex에 할당

			if (maxIndex != last) // maxIndex가 last가 아니면 두 인덱스의 값을 스왑 
				swap(sortedData, maxIndex, last);
		}
	}

	int selectMax(T[] dataList, int last) {
		T max = dataList[0]; // dataList[0]를 최대값으로 가정
		int maxIndex = 0; // maxIndex를 생성

		for (int i = 1; i <= last; i++) { // 최대값의 인덱스를 maxIndex에 할당
			//if (dataList[i] > max)
			if (dataList[i].compareTo(max) > 0) {
				max = dataList[i];
				maxIndex = i;
			}
		}
		return maxIndex; // maxIndex를 리턴
	}

}
