import os
import re
import glob

# Chapter mappings
CHAPTERS = [
    # Part 01
    {'num': 1, 'path': 'src/part01/01/index.md', 'part': '객체지향 자바 프로그래밍', 'part_dir': 'part01', 'sub': 'Chapter 01. 자바 시작하기'},
    {'num': 2, 'path': 'src/part01/02/index.md', 'part': '객체지향 자바 프로그래밍', 'part_dir': 'part01', 'sub': 'Chapter 02. 변수와 타입'},
    {'num': 3, 'path': 'src/part01/03/index.md', 'part': '객체지향 자바 프로그래밍', 'part_dir': 'part01', 'sub': 'Chapter 03. 연산자'},
    {'num': 4, 'path': 'src/part01/04/index.md', 'part': '객체지향 자바 프로그래밍', 'part_dir': 'part01', 'sub': 'Chapter 04. 조건문과 반복문'},
    # Part 02
    {'num': 5, 'path': 'src/part02/05/index.md', 'part': '객체지향 자바 프로그래밍', 'part_dir': 'part02', 'sub': 'Chapter 05. 참조 타입'},
    {'num': 6, 'path': 'src/part02/06/index.md', 'part': '객체지향 자바 프로그래밍', 'part_dir': 'part02', 'sub': 'Chapter 06. 클래스', 'skip_split': True},
    {'num': 7, 'path': 'src/part02/07/index.md', 'part': '객체지향 자바 프로그래밍', 'part_dir': 'part02', 'sub': 'Chapter 07. 상속'},
    {'num': 8, 'path': 'src/part02/08/index.md', 'part': '객체지향 자바 프로그래밍', 'part_dir': 'part02', 'sub': 'Chapter 08. 인터페이스'},
    {'num': 9, 'path': 'src/part02/09/index.md', 'part': '객체지향 자바 프로그래밍', 'part_dir': 'part02', 'sub': 'Chapter 09. 중첩 선언과 익명 객체'},
    {'num': 10, 'path': 'src/part02/10/index.md', 'part': '객체지향 자바 프로그래밍', 'part_dir': 'part02', 'sub': 'Chapter 10. 라이브러리와 모듈'},
    {'num': 11, 'path': 'src/part02/11/index.md', 'part': '객체지향 자바 프로그래밍', 'part_dir': 'part02', 'sub': 'Chapter 11. 예외 처리'},
    # Part 03
    {'num': 12, 'path': 'src/part03/12/index.md', 'part': '라이브러리 활용', 'part_dir': 'part03', 'sub': 'Chapter 12. java.base 모듈'},
    {'num': 13, 'path': 'src/part03/13/index.md', 'part': '라이브러리 활용', 'part_dir': 'part03', 'sub': 'Chapter 13. 제네릭'},
    {'num': 14, 'path': 'src/part03/14/index.md', 'part': '라이브러리 활용', 'part_dir': 'part03', 'sub': 'Chapter 14. 멀티 스레드'},
    {'num': 15, 'path': 'src/part03/15/index.md', 'part': '라이브러리 활용', 'part_dir': 'part03', 'sub': 'Chapter 15. 컬렉션 자료구조'},
    {'num': 16, 'path': 'src/part03/16/index.md', 'part': '라이브러리 활용', 'part_dir': 'part03', 'sub': 'Chapter 16. 스트림과 병렬 처리'},
    {'num': 17, 'path': 'src/part03/17/index.md', 'part': '라이브러리 활용', 'part_dir': 'part03', 'sub': 'Chapter 17. 데이터 입출력'},
    # Part 04
    {'num': 18, 'path': 'src/part04/18/index.md', 'part': '데이터 입출력', 'part_dir': 'part04', 'sub': 'Chapter 18. JDBC'},
    {'num': 19, 'path': 'src/part04/19/index.md', 'part': '데이터 입출력', 'part_dir': 'part04', 'sub': 'Chapter 19. 네트워크 입출력'},
    {'num': 20, 'path': 'src/part04/20/index.md', 'part': '데이터 입출력', 'part_dir': 'part04', 'sub': 'Chapter 20. 람다식'},
    # Part 05
    {'num': 21, 'path': 'src/part05/21/index.md', 'part': '최신 자바', 'part_dir': 'part05', 'sub': 'Chapter 21. 스트림 심화'},
    {'num': 22, 'path': 'src/part05/22/index.md', 'part': '최신 자바', 'part_dir': 'part05', 'sub': 'Chapter 22. 부록'},
    {'num': 23, 'path': 'src/part05/23/index.md', 'part': '최신 자바', 'part_dir': 'part05', 'sub': 'Chapter 23. 부록'},
    {'num': 24, 'path': 'src/part05/24/index.md', 'part': '최신 자바', 'part_dir': 'part05', 'sub': 'Chapter 24. 부록'},
    {'num': 25, 'path': 'src/part05/25/index.md', 'part': '최신 자바', 'part_dir': 'part05', 'sub': 'Chapter 25. 부록'},
]

CHAPTER_OBJECTIVES = {
    1: "자바 프로그래밍 환경을 구축하고 간단한 프로그램을 작성해 봅니다.",
    2: "변수의 개념과 다양한 데이터 타입(정수, 실수, 논리)을 이해합니다.",
    3: "프로그래밍에서 데이터를 처리하기 위한 다양한 연산자의 종류와 기능을 학습합니다.",
    4: "조건문과 반복문을 사용하여 프로그램의 실행 흐름을 제어하는 방법을 배웁니다.",
    5: "기본 타입과 달리 객체를 참조하는 참조 타입(배열, 열거, 문자열)의 특성을 이해합니다.",
    6: "객체지향 프로그래밍의 핵심인 클래스, 객체, 필드, 메소드, 생성자를 학습합니다.",
    7: "기존 클래스를 재사용하여 새로운 클래스를 만드는 상속의 개념과 다형성을 배웁니다.",
    8: "객체의 사용 방법을 정의하는 인터페이스와 다형성 구현 방법을 학습합니다.",
    9: "클래스 내부에 선언되는 중첩 클래스와 익명 객체의 활용법을 알아봅니다.",
    10: "자바의 표준 라이브러리와 모듈 시스템을 이해하고 활용하는 방법을 배웁니다.",
    11: "프로그램 실행 중 발생할 수 있는 예외를 처리하고 안전한 코드를 작성하는 방법을 학습합니다.",
    12: "java.base 모듈에서 제공하는 주요 클래스(Object, String, System 등)의 기능을 익힙니다.",
    13: "데이터 타입을 파라미터화하여 코드의 안정성과 재사용성을 높이는 제네릭을 배웁니다.",
    14: "동시에 여러 작업을 처리하는 멀티 스레드 프로그래밍의 기초와 동기화를 학습합니다.",
    15: "데이터를 효율적으로 저장하고 관리하는 컬렉션 프레임워크(List, Set, Map)를 알아봅니다.",
    16: "데이터의 집합을 함수형 스타일로 처리하는 스트림과 병렬 처리 기법을 배웁니다.",
    17: "데이터의 입력과 출력을 담당하는 입출력 스트림의 종류와 사용법을 학습합니다.",
    18: "자바와 데이터베이스를 연결하여 데이터를 저장하고 관리하는 JDBC 프로그래밍을 배웁니다.",
    19: "TCP/UDP 네트워크 프로그래밍을 통해 데이터를 주고받는 통신 프로그램을 작성해 봅니다.",
    20: "함수형 프로그래밍을 지원하는 람다식의 문법과 활용 방법을 학습합니다.",
    21: "자바의 최신 기능인 스트림 심화 과정과 고급 활용법을 배웁니다.",
    22: "부록 학습: 데이터베이스 입출력 심화 및 추가 주제를 다룹니다.",
    23: "부록 학습: Java UI - Swing 기초를 학습합니다.",
    24: "부록 학습: Java UI - JavaFX 기초를 학습합니다.",
    25: "부록 학습: NIO 기반 입출력 및 네트워킹을 학습합니다."
}

def extract_summary(content, length=150):
    """Extracts the first paragraph as summary, stripping markdown."""
    # Remove headers
    lines = content.split('\n')
    text = ""
    for line in lines:
        line = line.strip()
        if not line: continue
        if line.startswith('#'): continue
        if line.startswith('```'): continue # Skip code blocks
        if line.startswith('>'): continue # Skip quotes
        if line.startswith('|'): continue # Skip tables
        if line.startswith('!['): continue # Skip images
        
        # Strip basic markdown formatting
        line = re.sub(r'[\*\`\[\]\(\)]', '', line) # Remove *, `, [, ], (, )
        line = re.sub(r'<.*?>', '', line) # Remove HTML tags
        
        # Take the first substantial text block
        text += line + " "
        if len(text) > length:
            break
            
    if not text:
        return "내용 설명이 없습니다."
        
    return text[:length].strip() + "..."

def scan_chapter(chapter_info):
    """Scans existing split files to generate nav items and descriptions."""
    dir_path = os.path.dirname(chapter_info['path'])
    files = glob.glob(os.path.join(dir_path, '*.md'))
    
    sections = []
    
    for file_path in files:
        filename = os.path.basename(file_path)
        if filename == 'index.md':
            continue
            
        with open(file_path, 'r', encoding='utf-8') as f:
            content = f.read()
            
        # Extract title from front matter
        title_match = re.search(r'title:\s*"(.*?)"', content)
        if title_match:
            title = title_match.group(1)
        else:
            title = filename
            
        # Determine sorting num
        if filename == 'quiz.md':
            num = 99
        else:
            try:
                num = int(filename.replace('.md', ''))
            except:
                num = 999
        
        # Extract body content (skip front matter)
        parts = content.split('---', 2)
        body = parts[2].strip() if len(parts) > 2 else content
        summary = extract_summary(body)

        sections.append({
            'title': title,
            'filename': filename,
            'num': num,
            'summary': summary
        })
        
    sorted_secs = sorted(sections, key=lambda x: x['num'])
    
    # Update Index for Scanned Chapter
    update_index_file(chapter_info, sorted_secs)
    
    return sorted_secs

def update_index_file(chapter_info, sections):
    file_path = chapter_info['path']
    objectives = CHAPTER_OBJECTIVES.get(chapter_info['num'], "이 장의 주요 내용을 학습합니다.")
    
    new_index_content = f"""---
layout: {chapter_info['part_dir']}
title: "{chapter_info['sub']}"
nav_order: {chapter_info['num']}
has_children: true
parent: "{chapter_info['part']}"
---

# {chapter_info['sub']}

## 학습목표

{objectives}

## 목차
"""
    has_quiz = False
    for sec in sections:
        if sec['filename'] == 'quiz.md':
            has_quiz = True
            continue
        link = sec['filename'].replace('.md', '')
        new_index_content += f"\n### [{sec['title']}](./{link})\n\n"
        new_index_content += f"{sec['summary']}\n" 

    if has_quiz:
        new_index_content += f"\n## 확인문제\n- [확인문제](./quiz)\n"

    with open(file_path, 'w', encoding='utf-8') as f:
        f.write(new_index_content)
    print(f"  Regenerated Index for {file_path}")

def split_node(body, matches):
    sections = []
    for i in range(len(matches)):
        start = matches[i].start()
        end = matches[i+1].start() if i + 1 < len(matches) else len(body)
        
        full_section = body[start:end].strip()
        header_title = matches[i].group(1).strip()
        
        # Check if Quiz
        is_quiz = "확인문제" in header_title
        section_num = 99
        section_title = header_title
        filename = "quiz.md"
        
        if not is_quiz:
            num_match = re.match(r'(\d+)\.(\d+)\s+(.*)', header_title)
            if num_match:
                section_num = int(num_match.group(2))
                filename = f"{section_num:02d}.md"
            else:
                 simple_match = re.match(r'(\d+)\.(\d+)', header_title)
                 if simple_match:
                     section_num = int(simple_match.group(2))
                     filename = f"{section_num:02d}.md"
                 else:
                    if "Chapter" in header_title or "부록" in header_title: continue
                    print(f"    Skipping header: {header_title}")
                    continue
        
        section_content = full_section[full_section.find('\n')+1:].strip() 
        summary = extract_summary(section_content)
        
        sections.append({
            'filename': filename,
            'title': header_title,
            'content': full_section, # Keep full content for split logic if we were rewriting
            'num': section_num,
            'summary': summary
        })
    return sections

# Original Logic Modified to reuse split_node for metadata
# BUT we are NOT re-splitting files that already exist to avoid overwriting edits
# UNLESS we want to force update everything.
# The user wants indices updated. We should rely on *scanning* existing files if they exist,
# or splitting if they don't.
# Since we just ran split, files exist. We should SCAN and UPDATE INDEX.

def process_chapters():
    generate_nav_files() # This function needs to be smarter now

def generate_nav_files():
    # Group by Part
    parts = {}
    for ch in CHAPTERS:
        p = ch['part_dir']
        if p not in parts:
            parts[p] = []
        parts[p].append(ch)
        
    for part_name, chapters in parts.items():
        print(f"Generating navigation for {part_name}...")
        
        yaml_content = "main:\n"
        
        for ch in chapters:
            # We will ALWAYS scan now because we assumed splitting is done or file exists
            # formatting index is our primary goal
            sections = scan_chapter(ch)
            
            # Add to YAML
            ch_num_str = f"{ch['num']:02d}"
            ch_url = f"/{part_name}/{ch_num_str}/"
            
            yaml_content += f"- title: {ch['sub']}\n"
            yaml_content += f"  url: {ch_url}\n"
            yaml_content += f"  subitems:\n"
            
            # Learning Objectives
            yaml_content += f"  - title: 학습목표\n"
            yaml_content += f"    url: {ch_url}\n"
            
            # Sections
            for sec in sections:
                if sec['filename'] == 'quiz.md':
                    sec_url = f"{ch_url}quiz/"
                else:
                    clean_name = sec['filename'].replace('.md', '')
                    sec_url = f"{ch_url}{clean_name}/"
                    
                yaml_content += f"  - title: {sec['title']}\n"
                yaml_content += f"    url: {sec_url}\n"
        
        # Write YAML file
        yaml_path = f"src/_data/{part_name}.yml"
        with open(yaml_path, 'w', encoding='utf-8') as f:
            f.write(yaml_content)
        print(f"Written {yaml_path}")

if __name__ == "__main__":
    process_chapters()
