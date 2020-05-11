package com.binary_studio.uniq_in_sorted_stream;

import java.util.Objects;

//You CAN modify this class
public final class Row<RowData> implements Comparable<Row<RowData>> {

	private final Long id;

	public Row(Long id) {
		this.id = id;
	}

	public Long getPrimaryId() {
		return this.id;
	}

	@Override
	public int compareTo(Row o) {
		return this.id.compareTo(o.getPrimaryId());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Row<?> row = (Row<?>) o;
		return Objects.equals(this.id, row.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
}
