import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import MultinomialNB
from sklearn.pipeline import Pipeline
import joblib

# 데이터 로드 및 전처리
data = pd.read_csv('tasks.csv')  # 작업 데이터셋 로드
X = data['description']  # 작업 설명을 입력 데이터로 사용
y = data['category']  # 카테고리를 출력 데이터로 사용

# 훈련 데이터와 테스트 데이터로 분리
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)

# 텍스트 데이터를 숫자로 변환하고, 분류 모델을 적용하는 파이프라인 생성
model = Pipeline([
    ('vect', TfidfVectorizer()),  # 텍스트 데이터를 TF-IDF 방식으로 벡터화
    ('clf', MultinomialNB())  # 다중
