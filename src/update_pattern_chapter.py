
import os
import re

base_dir = "/Users/hojin8/docs/070.강의/d02.객체지향자바프로그래밍/src/oop/pattern"

def update_chapter_number():
    # 1. Update main index.md
    main_index = os.path.join(base_dir, "index.md")
    if os.path.exists(main_index):
        with open(main_index, "r", encoding="utf-8") as f:
            content = f.read()
        
        # Replace Title and Nav Order
        # It was likely Chapter 17 based on my previous script
        content = re.sub(r'title: "Chapter \d+\. 디자인 패턴"', 'title: "Chapter 19. 디자인 패턴"', content)
        content = re.sub(r'nav_order: \d+', 'nav_order: 19', content)
        content = re.sub(r'# Chapter \d+\. 디자인 패턴', '# Chapter 19. 디자인 패턴', content)
        
        with open(main_index, "w", encoding="utf-8") as f:
            f.write(content)
        print("Updated main index.md to Chapter 19")
        
    # 2. Update subdirectories
    for root, dirs, files in os.walk(base_dir):
        for file in files:
            if file == "index.md" and root != base_dir:
                file_path = os.path.join(root, file)
                with open(file_path, "r", encoding="utf-8") as f:
                    content = f.read()
                
                # Replace Parent
                # parent: "Chapter 17. 디자인 패턴"
                content = re.sub(r'parent: "Chapter \d+\. 디자인 패턴"', 'parent: "Chapter 19. 디자인 패턴"', content)
                
                with open(file_path, "w", encoding="utf-8") as f:
                    f.write(content)
                print(f"Updated parent in {file_path}")

if __name__ == "__main__":
    update_chapter_number()
