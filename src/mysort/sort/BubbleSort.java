package mysort.sort;

public class BubbleSort<T extends Comparable> extends Sort<T> { // Sort(추상클래스)를 상속받은 BubbleSort 클래스를 생성

	@Override
	public void sort(T[] dataList) {
		setData(dataList); // Sort의 dataList객체를 생성
		for (int last = sortedData.length - 1; last >= 1; last--) { // 마지막 인덱스(last)에서 시작, 배치 시 last -1
			for (int i = 0; i <= last - 1; i++) { // sortedData의 첫 인덱스부터 last까지 2개씩 비교해서 높은 수치를 높은 인덱스에 배치(스왑 사용)
				if (sortedData[i].compareTo(sortedData[i+1]) > 0)
					swap(sortedData, i, i+1);
			}
		}
	}
}
