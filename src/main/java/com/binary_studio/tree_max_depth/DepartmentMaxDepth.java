package com.binary_studio.tree_max_depth;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public final class DepartmentMaxDepth {

	private DepartmentMaxDepth() {
	}

	public static Integer calculateMaxDepthWithRecursion(Department rootDepartment) {
		if (rootDepartment == null) {
			return 0;
		}
		List<Department> subDepartments = rootDepartment.subDepartments;
		if (subDepartments.isEmpty()) {
			return 1;
		}
		List<Integer> longest = subDepartments.stream().map(DepartmentMaxDepth::calculateMaxDepth).collect(Collectors.toList());
		return Collections.max(longest) + 1;
	}

	public static int calculateMaxDepth(Department rootDepartment) {
		int depth = 0;
		Stack<Department> wq = new Stack<>();
		Stack<Department> path = new Stack<>();

		if (rootDepartment == null) {
			return 0;
		}
		Department currentDepartment = rootDepartment;
		wq.push(currentDepartment);
		while (!wq.empty()) {
			currentDepartment = wq.peek();
			if (!path.empty() && currentDepartment == path.peek()) {
				if (path.size() > depth) {
					depth = path.size();
				}
				path.pop();
				wq.pop();
			}
			else {
				path.push(currentDepartment);
				if (currentDepartment.subDepartments != null) {
					currentDepartment.subDepartments.forEach(child -> {
						if (child != null) {
							wq.push(child);
						}
					});
				}
			}
		}
		return depth;
	}
}
